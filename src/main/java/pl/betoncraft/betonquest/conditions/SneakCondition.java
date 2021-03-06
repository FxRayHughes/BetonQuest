package pl.betoncraft.betonquest.conditions;

import pl.betoncraft.betonquest.Instruction;
import pl.betoncraft.betonquest.api.Condition;
import pl.betoncraft.betonquest.utils.PlayerConverter;

/**
 * Returns true if the player is sneaking
 */
@SuppressWarnings("PMD.CommentRequired")
public class SneakCondition extends Condition {

    public SneakCondition(final Instruction instruction) {
        super(instruction, true);
    }

    @Override
    protected Boolean execute(final String playerID) {
        return PlayerConverter.getPlayer(playerID).isSneaking();
    }

}
