package core;

class Utils {
    public static ChipType swapPlayers(ChipType currentPlayer) {
        return currentPlayer == ChipType.Black ? ChipType.White : ChipType.Black;
    }
}
