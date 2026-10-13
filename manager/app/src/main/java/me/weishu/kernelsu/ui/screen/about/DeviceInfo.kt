package me.weishu.kernelsu.ui.screen.about

import android.os.Build

data class DeviceInfo(
    val model: String,
    val androidVersion: String,
    val kernelVersion: String,
)

fun getDeviceInfo(): DeviceInfo {
    val kernelVersion = try {
        java.io.File("/proc/version").readText().trim()
    } catch (_: Exception) {
        "Unavailable"
    }

    return DeviceInfo(
        model = Build.MODEL ?: "Unknown",
        androidVersion = Build.VERSION.RELEASE ?: "Unknown",
        kernelVersion = kernelVersion,
    )
}
