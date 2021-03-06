package pl.betoncraft.betonquest.compatibility.mmogroup.mmolib;


import net.mmogroup.mmolib.api.player.MMOPlayerData;
import org.bukkit.entity.Player;
import pl.betoncraft.betonquest.Instruction;
import pl.betoncraft.betonquest.api.Condition;
import pl.betoncraft.betonquest.exceptions.InstructionParseException;
import pl.betoncraft.betonquest.exceptions.QuestRuntimeException;
import pl.betoncraft.betonquest.utils.PlayerConverter;

@SuppressWarnings("PMD.CommentRequired")
public class MMOLibStatCondition extends Condition {

    private final String statName;
    private final double targetLevel;
    private boolean mustBeEqual;

    public MMOLibStatCondition(final Instruction instruction) throws InstructionParseException {
        super(instruction, true);

        statName = instruction.next();
        targetLevel = instruction.getDouble();
        if (instruction.hasArgument("equal")) {
            mustBeEqual = true;
        }
    }

    @Override
    protected Boolean execute(final String playerID) throws QuestRuntimeException {
        final Player player = PlayerConverter.getPlayer(playerID);
        final MMOPlayerData data = MMOPlayerData.get(player);
        final double actualLevel = data.getStatMap().getStat(statName);
        return mustBeEqual ? actualLevel == targetLevel : actualLevel >= targetLevel;
    }

}
