package me.nathanfallet.myappsandroid.preferences

import android.content.Context
import android.util.TypedValue
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.preference.Preference
import androidx.preference.PreferenceViewHolder

class MyAppPreference(context: Context): Preference(context) {

    override fun onBindViewHolder(holder: PreferenceViewHolder) {
        super.onBindViewHolder(holder)

        // Create a card view with icon, and inject it

        val icon = holder.findViewById(android.R.id.icon)
        val linearLayout = icon.parent as? LinearLayout

        linearLayout?.let {
            it.removeView(icon)

            val cardView = CardView(context)
            cardView.addView(icon)
            cardView.radius = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                8f,
                context.resources.displayMetrics
            )

            it.addView(cardView, 0)
        }
    }

}