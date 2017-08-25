import android.app.Activity
import android.net.Uri
import android.content.Intent

/**
 * Common Intent Extensions
 *
 * Created by Tyler McCraw on 8/25/17.
 */

/**
 * Start a new view intent with a URL
 * which should provide options to the user
 * for opening up the specified URL
 *
 * @param url url to open
 */
fun Activity.startViewUrlIntent(url: String) {
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
}

/**
 * Start a new intent to open the device's
 * phone dialer activity
 *
 * @param phoneNumber phone number to auto fill
 */
fun Activity.startPhoneDialerIntent(phoneNumber: String) {
    startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber")))
}

/**
 * Start a new intent to let the user
 * send an email with a recipient address, subject, and body
 *
 * @param toAddress email address of recipient
 * @param subject subject of email
 * @param body body of email
 */
fun Activity.startEmailIntent(toAddress: String, subject: String, body: String) {
    startActivity(Intent(Intent.ACTION_SENDTO).apply {
        val encodedSubject = Uri.encode(subject)
        val encodedBody = Uri.encode(body)
        data = Uri.parse("mailto:$toAddress?&subject=$encodedSubject&body=$encodedBody")
    })
}
