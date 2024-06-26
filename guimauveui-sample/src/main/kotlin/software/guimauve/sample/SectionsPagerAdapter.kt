package software.guimauve.sample

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SectionsPagerAdapter(
    private val context: Context,
    fm: FragmentManager,
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val tabTitles = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2,
        R.string.tab_text_3
    )

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> ComposeFragment()
        else -> throw IllegalArgumentException("Invalid position")
    }

    override fun getPageTitle(position: Int): CharSequence = context.resources.getString(tabTitles[position])

    override fun getCount(): Int = 1

}
