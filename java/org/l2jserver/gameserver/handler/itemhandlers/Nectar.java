/*
 * This file is part of the L2JServer project.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.l2jserver.gameserver.handler.itemhandlers;

import org.l2jserver.gameserver.datatables.SkillTable;
import org.l2jserver.gameserver.handler.IItemHandler;
import org.l2jserver.gameserver.model.WorldObject;
import org.l2jserver.gameserver.model.actor.Playable;
import org.l2jserver.gameserver.model.actor.instance.GourdInstance;
import org.l2jserver.gameserver.model.actor.instance.PlayerInstance;
import org.l2jserver.gameserver.model.items.instance.ItemInstance;
import org.l2jserver.gameserver.network.SystemMessageId;

public class Nectar implements IItemHandler
{
	private static final int[] ITEM_IDS =
	{
		6391
	};
	
	@Override
	public void useItem(Playable playable, ItemInstance item)
	{
		if (!(playable instanceof PlayerInstance))
		{
			return;
		}
		
		final PlayerInstance player = (PlayerInstance) playable;
		if (!(player.getTarget() instanceof GourdInstance))
		{
			player.sendPacket(SystemMessageId.THAT_IS_THE_INCORRECT_TARGET);
			return;
		}
		
		if (!player.getName().equalsIgnoreCase(((GourdInstance) player.getTarget()).getOwner()))
		{
			player.sendPacket(SystemMessageId.THAT_IS_THE_INCORRECT_TARGET);
			return;
		}
		
		final WorldObject[] targets = new WorldObject[1];
		targets[0] = player.getTarget();
		
		final int itemId = item.getItemId();
		if (itemId == 6391)
		{
			player.useMagic(SkillTable.getInstance().getInfo(9998, 1), false, false);
		}
	}
	
	@Override
	public int[] getItemIds()
	{
		return ITEM_IDS;
	}
}
