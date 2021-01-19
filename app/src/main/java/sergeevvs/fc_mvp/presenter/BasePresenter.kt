package sergeevvs.fc_mvp.presenter

import sergeevvs.fc_mvp.view.MvpView

abstract class BasePresenter<V : MvpView> : MvpPresenter<V> {

    var view: V? = null

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

}