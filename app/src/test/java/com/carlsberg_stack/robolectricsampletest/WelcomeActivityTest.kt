package com.carlsberg_stack.robolectricsampletest

import android.app.Activity
import android.os.Build
import android.widget.TextView
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class WelcomeActivityTest {

    var activity : Activity? = null

    @Before
    fun setup() {
        activity = Robolectric.buildActivity(WelcomeActivity::class.java).create().get()
    }

    @Test
    fun testWelcomeMessage() {
        val welcomeMessage = activity?.findViewById<TextView>(R.id.welcome_message)
        assertEquals(activity?.getString(R.string.hello_novopay), welcomeMessage?.text.toString())
    }

}