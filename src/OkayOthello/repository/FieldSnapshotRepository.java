package OkayOthello.repository;

import OkayOthello.core.ChipType;
import OkayOthello.core.FieldSnapshot;

public class FieldSnapshotRepository extends Repository<FieldSnapshot> {
    public boolean anyPlayerSnapshot(ChipType playerChip) {
        return items.stream().anyMatch(snapshot -> snapshot.playerChip() == playerChip);
    }

    public FieldSnapshot popUntilPlayerLastMove(ChipType playerChip) {
        var lastSnapshot = items.stream()
                .filter(snapshot -> snapshot.playerChip() == playerChip)
                .reduce((first, second) -> second)
                .orElse(null);
        if (lastSnapshot == null) {
            throw new IndexOutOfBoundsException("This player has no saved snapshots");
        }
        var lastSnapshotIndex = items.lastIndexOf(lastSnapshot);
        items.removeIf(snapshot -> items.indexOf(snapshot) >= lastSnapshotIndex);
        return lastSnapshot;
    }
}
