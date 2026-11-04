package com.fischmate.mobile

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

/** Accessibility bridge. Gesture automation is intentionally not enabled until
 * screen recognition and safe start/stop conditions are implemented and tested. */
class FishingAccessibilityService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent?) = Unit
    override fun onInterrupt() = stopAutomation()

    override fun onServiceConnected() {
        instance = this
    }

    override fun onDestroy() {
        if (instance === this) instance = null
        super.onDestroy()
    }

    companion object {
        @Volatile private var instance: FishingAccessibilityService? = null
        fun stopAutomation() {
            // Reserved for the final fishing-cycle controller.
        }
    }
}
