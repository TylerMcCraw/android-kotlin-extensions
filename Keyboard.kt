import android.app.Activity
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager

/**
 * Keyboard Extensions
 *
 * Created by Tyler McCraw on 8/25/17.
 */

/**
 * Opens the soft keyboard
 *
 * @param activity The currently open activity
 * @param view     The view that has focus
 */
fun Activity.openKeyboard(view: View) {
    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
}

/**
 * Closes the soft keyboard
 *
 * @param view The view that has focus
 */
fun Activity.closeKeyboard(view: View) {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}
