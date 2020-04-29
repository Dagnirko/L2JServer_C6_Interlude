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
package org.l2jserver.gameserver.model.skills.effects;

import org.l2jserver.gameserver.model.Effect;
import org.l2jserver.gameserver.model.actor.Creature;
import org.l2jserver.gameserver.model.skills.Env;

public class EffectPetrification extends Effect
{
	public EffectPetrification(Env env, EffectTemplate template)
	{
		super(env, template);
	}
	
	@Override
	public EffectType getEffectType()
	{
		return Effect.EffectType.PETRIFICATION;
	}
	
	@Override
	public void onStart()
	{
		getEffected().startAbnormalEffect(Creature.ABNORMAL_EFFECT_HOLD_2);
		getEffected().setPetrified(true);
	}
	
	@Override
	public void onExit()
	{
		getEffected().stopAbnormalEffect(Creature.ABNORMAL_EFFECT_HOLD_2);
		getEffected().setPetrified(false);
	}
	
	@Override
	public boolean onActionTime()
	{
		return false;
	}
}
