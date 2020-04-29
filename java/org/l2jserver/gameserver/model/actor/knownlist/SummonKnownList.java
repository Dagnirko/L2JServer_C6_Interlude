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
package org.l2jserver.gameserver.model.actor.knownlist;

import org.l2jserver.gameserver.model.WorldObject;
import org.l2jserver.gameserver.model.actor.Summon;

public class SummonKnownList extends PlayableKnownList
{
	public SummonKnownList(Summon activeChar)
	{
		super(activeChar);
	}
	
	@Override
	public Summon getActiveChar()
	{
		return (Summon) super.getActiveChar();
	}
	
	@Override
	public int getDistanceToForgetObject(WorldObject object)
	{
		if ((object == getActiveChar().getOwner()) || (object == getActiveChar().getTarget()))
		{
			return 6000;
		}
		return 3000;
	}
	
	@Override
	public int getDistanceToWatchObject(WorldObject object)
	{
		return 1500;
	}
}
