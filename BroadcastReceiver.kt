
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager

/**
 * BroadcastReceiver Extensions
 *
 * Created by Tyler McCraw on 8/2/17.
 */
 
/**
 * Register a BroadcastReceiver which is guaranteed to
 * receive change events when the network connects and disconnects
 *
 * Call this extension from your Activity's onStart(), keep a reference
 * to the returned receiver and unregister it in onStop()
 *
 * Note: If you support devices on Honeycomb or earlier,
 * then you must call this in onResume() and unregister in onPause()
 */
fun Context.registerNetworkChangeReceiver(onNetworkConnected: () -> Unit,
                                          onNetworkDisconnected: () -> Unit): BroadcastReceiver {
    val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent?) {
            if (intent == null || intent.extras == null) {
                return
            }

            with(context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager) {
                if (activeNetworkInfo.isConnectedOrConnecting) {
                    onNetworkConnected()
                } else {
                    onNetworkDisconnected()
                }
            }
        }
    }
    this.registerReceiver(receiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    return receiver
}
