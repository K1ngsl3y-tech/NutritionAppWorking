import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kingsley.fitnessapp.data.Progress
import com.kingsley.fitnessapp.data.ProgressRepository
import com.kingsley.fitnessapp.data.ProgressDatabase

class ProgressViewModel(application: Application) : AndroidViewModel(application) {

    private val progressRepository: ProgressRepository =
        ProgressRepository(ProgressDatabase.getDatabase(application).progressDao())

    // LiveData to observe all progress entries
    val allProgress: LiveData<List<Progress>> = progressRepository.getAllProgress()

    // Add new progress entry
    suspend fun addNewProgress(progress: Progress) {
        progressRepository.addNewProgress(progress)
    }
}
