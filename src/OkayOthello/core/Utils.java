package OkayOthello.core;

class Utils {
    public static ChipType swapChip(ChipType chip) {
        return chip == ChipType.Black ? ChipType.White : ChipType.Black;
    }
}
