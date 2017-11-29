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
 * Add a fragment in a container view
 *
 * @param containerViewId Optional identifier of the container this fragment is
 * to be placed in.  If 0, it will not be placed in a container.
 * @param fragment The fragment to be added.  This fragment must not already
 * be added to the activity.
 * @param tag Optional tag name for the fragment, to later retrieve the
 * fragment with {@link FragmentManager#findFragmentByTag(String)
 * FragmentManager.findFragmentByTag(String)}.
 */
fun android.support.v4.app.FragmentManager.addFragment(@IdRes containerViewId: Int,
        fragment: android.support.v4.app.Fragment, tag: String? = null) {
    beginTransaction().add(containerViewId, fragment, tag).commit()
}

/**
 * Add a fragment in a container view
 *
 * @param containerViewId Optional identifier of the container this fragment is
 * to be placed in.  If 0, it will not be placed in a container.
 * @param fragment The fragment to be added.  This fragment must not already
 * be added to the activity.
 * @param tag Optional tag name for the fragment, to later retrieve the
 * fragment with {@link FragmentManager#findFragmentByTag(String)
 * FragmentManager.findFragmentByTag(String)}.
 */
fun android.app.FragmentManager.addFragment(@IdRes containerViewId: Int,
        fragment: android.app.Fragment, tag: String? = null) {
    beginTransaction().add(containerViewId, fragment, tag).commit()
}

/**
 * Replace a fragment in a container view
 *
 * @param containerViewId Optional identifier of the container this fragment is
 * to be placed in.  If 0, it will not be placed in a container.
 * @param fragment The fragment to be added.  This fragment must not already
 * be added to the activity.
 * @param tag Optional tag name for the fragment, to later retrieve the
 * fragment with {@link FragmentManager#findFragmentByTag(String)
 * FragmentManager.findFragmentByTag(String)}.
 */
fun android.support.v4.app.FragmentManager.replaceFragment(@IdRes containerViewId: Int,
        fragment: android.support.v4.app.Fragment, tag: String? = null) {
    beginTransaction().replace(containerViewId, fragment, tag).commit()
}

/**
 * Replace a fragment in a container view
 *
 * @param containerViewId Optional identifier of the container this fragment is
 * to be placed in.  If 0, it will not be placed in a container.
 * @param fragment The fragment to be added.  This fragment must not already
 * be added to the activity.
 * @param tag Optional tag name for the fragment, to later retrieve the
 * fragment with {@link FragmentManager#findFragmentByTag(String)
 * FragmentManager.findFragmentByTag(String)}.
 */
fun android.app.FragmentManager.replaceFragment(@IdRes containerViewId: Int,
        fragment: android.app.Fragment, tag: String? = null) {
    beginTransaction().replace(containerViewId, fragment, tag).commit()
}
