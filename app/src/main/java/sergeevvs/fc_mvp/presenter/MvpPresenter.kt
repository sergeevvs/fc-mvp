package sergeevvs.fc_mvp.presenter

import sergeevvs.fc_mvp.view.MvpView

interface MvpPresenter<V : MvpView> {
    fun attachView(view: V)
    fun detachView()
    fun viewIsReady()
}