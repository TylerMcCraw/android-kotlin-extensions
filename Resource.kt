import android.support.annotation.AttrRes
import android.support.annotation.ColorInt

/**
 * Android Resources Extensions
 *
 * Created by Tyler McCraw on 8/25/17.
 */

 /**
  * Get a theme color from an attribute res
  *
  * @param attributeColor attribute key for the color
  */
 @ColorInt
 fun Context.getThemeColor(@AttrRes attributeColor: Int): Int {
     val value = TypedValue()
     theme.resolveAttribute(attributeColor, value, true)
     return value.data
 }
