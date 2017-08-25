import android.support.annotation.IdRes
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 * Fragment and FragmentManager Extensions
 *
 * Created by Tyler McCraw on 8/25/17.
 */

/**
 * Execute as many fragment transactions in a transaction block, like so:
 * supportFragmentManager.inTransaction {
 *     remove(fragmentA)
 *     add(R.id.frameLayoutContent, fragmentB)
 * }
 *
 * https://medium.com/thoughts-overflow/how-to-add-a-fragment-in-kotlin-way-73203c5a450b
 */
inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commit()
}

/**
 * Replace a fragment in a container view
 *
 * @param containerViewId id of container view
 * @param fragment fragment to use as replacement
 */
fun android.support.v4.app.FragmentManager.replaceFragment(@IdRes containerViewId: Int, fragment: android.support.v4.app.Fragment) {
    beginTransaction().replace(containerViewId, fragment).commit()
}

/**
 * Replace a fragment in a container view
 *
 * @param containerViewId id of container view
 * @param fragment fragment to use as replacement
 */
fun android.app.FragmentManager.replaceFragment(@IdRes containerViewId: Int, fragment: android.app.Fragment) {
    beginTransaction().replace(containerViewId, fragment).commit()
}
