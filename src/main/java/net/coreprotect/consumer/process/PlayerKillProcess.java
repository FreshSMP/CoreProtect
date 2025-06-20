package net.coreprotect.consumer.process;

import java.sql.PreparedStatement;

import org.bukkit.block.BlockState;
import org.bukkit.entity.EntityType;

import net.coreprotect.database.logger.PlayerKillLogger;

class PlayerKillProcess {

    static void process(PreparedStatement preparedStmt, int batchCount, int id, Object object, String user) {
        if (object instanceof Object[] data && data.length >= 2) {
            BlockState block = (BlockState) data[0];

            String player;
            if (data[1] instanceof String) {
                player = (String) data[1];
            } else if (data[1] instanceof EntityType) {
                player = ((EntityType) data[1]).name();
            } else {
                player = "UNKNOWN";
            }

            PlayerKillLogger.log(preparedStmt, batchCount, user, block, player);
        }
    }
}
