package KafkaMonitoringExtensionCi.patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with uuid = '75c498f0-14c7-45a6-a538-53ad0f9b87dc' (id = 'KafkaMonitoringExtensionCi_Build')
accordingly, and delete the patch script.
*/
changeBuildType(uuid("75c498f0-14c7-45a6-a538-53ad0f9b87dc")) {
    vcs {

        check(cleanCheckout == false) {
            "Unexpected option value: cleanCheckout = $cleanCheckout"
        }
        cleanCheckout = true
    }
}