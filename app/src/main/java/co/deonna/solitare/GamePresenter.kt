package co.deonna.solitare

class GamePresenter {

    var view: GameView? = null

    fun setGameView(gameView: GameView) {

        view = gameView
    }

    fun onDeckTap() {

        GameModel.onDeckTap()
        view?.update()
    }

    fun onWasteTap() {

        GameModel.onWasteTap()
        view?.update()
    }

    fun onTableauTap(tableauIndex: Int, cardIndex: Int) {

        GameModel.onTableauTap(tableauIndex, cardIndex)
        view?.update()
    }

    fun onFoundationTap(tappedIndex: Int) {

        GameModel.onFoundationTap(tappedIndex)
        view?.update()
    }
}