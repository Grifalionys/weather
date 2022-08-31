package grifalion.ru.gallery


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import grifalion.ru.gallery.databinding.MainLayoutBinding
import grifalion.ru.gallery.fragments.MainFragment
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    lateinit var binding: MainLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.constrActivityMain,MainFragment.newInstance())
            .commit()
    }
}








