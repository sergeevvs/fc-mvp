package sergeevvs.fc_mvp.presenters

import sergeevvs.fc_mvp.interfaces.MvpContract

abstract class BasePresenter<V : MvpContract.IView> : MvpContract.IPresenter<V> {

    var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }

}