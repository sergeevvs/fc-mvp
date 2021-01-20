package sergeevvs.fc_mvp.squad

import android.os.Bundle
import sergeevvs.fc_mvp.main.MvpView

interface SquadListFragment : MvpView {

    fun getArguments(): Bundle?
    fun updateList()
}