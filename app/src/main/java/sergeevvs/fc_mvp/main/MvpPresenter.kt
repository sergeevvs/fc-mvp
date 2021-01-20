package sergeevvs.fc_mvp.main

interface MvpPresenter<V : MvpView> {

    fun attachView(view: V)
    fun detachView()
    fun viewIsReady()
}