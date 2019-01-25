package KafkaMonitoringExtensionCi.patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.MavenBuildStep
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.dockerCompose
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with uuid = '8d38ea0b-5554-4d51-9ca2-aa3897610fdb' (id = 'KafkaMonitoringExtensionCi_Build')
accordingly, and delete the patch script.
*/
changeBuildType(uuid("8d38ea0b-5554-4d51-9ca2-aa3897610fdb")) {
    check(artifactRules == "target/KafkaMonitor-*.zip") {
        "Unexpected option value: artifactRules = $artifactRules"
    }
    artifactRules = ""

    expectSteps {
        maven {
            goals = "clean install"
            mavenVersion = defaultProvidedVersion()
            jdkHome = "%env.JDK_18%"
        }
    }
    steps {
        insert(0) {
            dockerCompose {
                file = "docker-compose.yml"
            }
        }
        insert(1) {
            dockerCommand {
                commandType = build {
                    source = path {
                        path = "Dockerfile"
                    }
                }
            }
        }
        update<MavenBuildStep>(2) {
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            param("teamcity.coverage.idea.includePatterns", "")
            param("teamcity.coverage.jacoco.patterns", "")
            param("teamcity.coverage.emma.instr.parameters", "")
            param("teamcity.coverage.emma.include.source", "")
        }
        insert(3) {
            script {
                scriptContent = "./broker-list.sh"
            }
        }
        insert(4) {
            script {
                scriptContent = "./create-topics.sh"
            }
        }
        insert(5) {
            script {
                scriptContent = "./download-kafka.sh"
            }
        }
        insert(6) {
            script {
                scriptContent = "./start-kafka-shell.sh"
            }
        }
        insert(7) {
            script {
                scriptContent = "./start-kafka.sh"
            }
        }
        insert(8) {
            script {
                scriptContent = "./versions.sh"
            }
        }
    }
}