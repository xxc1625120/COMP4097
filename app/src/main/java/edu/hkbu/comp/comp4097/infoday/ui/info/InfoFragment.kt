package edu.hkbu.comp.comp4097.infoday.ui.info

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class InfoFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}
