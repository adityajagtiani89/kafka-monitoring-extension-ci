package KafkaMonitoringExtensionCi.patches.projects

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project
import jetbrains.buildServer.configs.kotlin.v2018_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the project with uuid = 'd8ec7368-9cde-4a3c-b444-e7c3d06d247a' (id = 'KafkaMonitoringExtensionCi')
accordingly, and delete the patch script.
*/
changeProject(uuid("d8ec7368-9cde-4a3c-b444-e7c3d06d247a")) {
    params {
        add {
            password("env.KAFKA_ENCRYPTED_PWD", "credentialsJSON:9d5aaccc-f179-4431-a402-2d52d5631716", display = ParameterDisplay.HIDDEN)
        }
        add {
            param("env.APPDYNAMICS_AGENT_ACCOUNT_ACCESS_KEY", "4c3eaeba-8115-44ef-89e7-80b0e3eed16a")
        }
        add {
            password("env.KAKFA_ENCRYPTION_KEY", "credentialsJSON:42aea520-eccf-4cbb-b251-2e209c4633a7", display = ParameterDisplay.HIDDEN)
        }
    }
}
