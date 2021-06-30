package teneocto.thiemjason.android_scorecounter.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import teneocto.thiemjason.android_scorecounter.models.Player;

public class HomeViewModel extends ViewModel {
    public MutableLiveData<ArrayList<Player>> players = new MutableLiveData<>();
    public MutableLiveData<String> gameName = new MutableLiveData<>();
    public MutableLiveData<Integer> maxScore = new MutableLiveData<>();
    public MutableLiveData<Integer> maxPlayers = new MutableLiveData<>();

    @Override
    protected void onCleared() {
        super.onCleared();

        this.loadPlayers();
    }

    /**
     * Start new game
     */
    public void startGame() {

    }

    /**
     * Load players
     */
    private void loadPlayers() {

    }
}
