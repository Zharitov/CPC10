package study.rtvx.cpc10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


private const val LAST_SELECTED_ITEM = "item"
class MainActivity : AppCompatActivity() {

    private lateinit var bottomMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomMenu = findViewById(R.id.bottom_menu)

        bottomMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.work -> {
                    val aboutUsFragment = AboutUsFragment()
                    replaceFragment(aboutUsFragment)
                }
                R.id.about -> {
                    val infoFragment = InfoFragment()
                    replaceFragment(infoFragment)
                }
            }

            true
        }
        bottomMenu.selectedItemId = savedInstanceState?.getInt(LAST_SELECTED_ITEM)?:R.id.work
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTED_ITEM,bottomMenu.selectedItemId)
    }
}