package sergeevvs.fc_mvp.interfaces

import sergeevvs.fc_mvp.RecyclerAdapter

interface IListPresenter : MvpContract.IPresenter<IListView> {

    fun onBindTeamAtPosition(holder: RecyclerAdapter.TeamCardHolder, position: Int)
    fun getTeamCount(): Int

}