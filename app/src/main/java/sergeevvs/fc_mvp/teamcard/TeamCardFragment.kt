package sergeevvs.fc_mvp.teamcard

import android.graphics.drawable.PictureDrawable
import android.os.Bundle
import androidx.navigation.NavController
import com.bumptech.glide.RequestBuilder
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.main.MvpView

interface TeamCardFragment: MvpView {

    fun getArguments(): Bundle?
    fun showTeam(team: Team, requestBuilder: RequestBuilder<PictureDrawable>)
}