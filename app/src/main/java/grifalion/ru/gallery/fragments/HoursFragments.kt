package grifalion.ru.gallery.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import grifalion.ru.gallery.MainViewModel
import grifalion.ru.gallery.R
import grifalion.ru.gallery.adapter.WeatherAdapter
import grifalion.ru.gallery.adapter.WeatherModel
import grifalion.ru.gallery.databinding.FragmentHoursBinding
import org.json.JSONArray
import org.json.JSONObject


class HoursFragments : Fragment() {
    private lateinit var binding: FragmentHoursBinding
    private lateinit var adapter: WeatherAdapter
    private val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHoursBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecView()
        model.liveDataCurrent.observe(viewLifecycleOwner){
           adapter.submitList(getHoursList(it))
        }
    }

    private fun initRecView() = with(binding) {
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter()
        rcView.adapter = adapter

    }
    private fun getHoursList(weatherItem: WeatherModel): List<WeatherModel>{
        val hoursArray = JSONArray(weatherItem.hours)
        val list = ArrayList<WeatherModel>()
        for(i in 0 until hoursArray.length()){
            val item = WeatherModel(
                weatherItem.city,
                (hoursArray[i] as JSONObject).getString("time"),
                (hoursArray[i] as JSONObject).getJSONObject("condition").getString("text"),
                (hoursArray[i] as JSONObject).getString("temp_c"),
                "",
                "",
                (hoursArray[i] as JSONObject).getJSONObject("condition").getString("icon"),
                ""

            )
            list.add(item)
        }
        return list
    }
    companion object {

        @JvmStatic
        fun newInstance() = HoursFragments()
    }
}