package sergeevvs.fc_mvp.presenters

import com.sergeevvs.footballcards.data.Team
import sergeevvs.fc_mvp.interfaces.IListPresenter
import sergeevvs.fc_mvp.interfaces.IListView
import sergeevvs.fc_mvp.models.ListModel
import sergeevvs.fc_mvp.views.ListFragment

class ListPresenter(val mModel: ListModel) : BasePresenter<IListView>(), IListPresenter {
    lateinit var teams: List<Team>

    override fun viewIsReady() {
        mView?.showTeams(/* если в teams пусто, запросить teams из модели */listOf())
    }
}