package com.carlsberg_stack.robolectricsampletest


import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Looper.getMainLooper
import android.widget.Button
import android.widget.EditText
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class MainActivityTest {

    var activity: Activity? = null

    // 3
    @Before
    fun setup() {
        activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
    }

    @Test
    @Throws(Exception::class)
    fun activityShouldNotBeNull() {
        assertNotNull(activity)
    }

    @Test
    fun shouldShowErrorMessage() {
        val emailAddress= activity?.findViewById<EditText>(R.id.email_address);
        emailAddress?.setText("amitgmail.com")
        activity?.findViewById<Button>(R.id.login)?.performClick()
        assertEquals(activity?.getString(R.string.err_invalid_email_address), emailAddress?.error)
    }

    @Test
    fun shouldStartWelcomeActivity() {
        activity?.findViewById<EditText>(R.id.email_address)?.setText("amit@gmail.com")
        activity?.findViewById<Button>(R.id.login)?.performClick()
        val expectedIntent = Intent(activity, WelcomeActivity::class.java)
        shadowOf(getMainLooper()).idle();
        val actual: Intent = shadowOf(activity).nextStartedActivity
        assertEquals(expectedIntent.component, actual.component)
    }
}