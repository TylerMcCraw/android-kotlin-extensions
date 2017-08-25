import android.content.Context
import android.net.ConnectivityManager

/**
 * Network/Connectivity Extensions
 *
 * Created by Tyler McCraw on 8/25/17.
 */

/**
 * Check if the network is available
 */
fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return connectivityManager.activeNetworkInfo?.isConnectedOrConnecting ?: false
}
