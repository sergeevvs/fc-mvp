package sergeevvs.fc_mvp.interfaces

interface MvpContract {

    interface IView

    interface IPresenter<V : IView> {
        fun attachView(view: V)
        fun detachView()
        fun viewIsReady()
    }

    interface IModel

}