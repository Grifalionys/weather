package grifalion.ru.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import grifalion.ru.gallery.adapter.WeatherModel

class MainViewModel : ViewModel() {
    val liveDataCurrent = MutableLiveData<WeatherModel>()
    val liveDataList  = MutableLiveData<List<WeatherModel>>()
}