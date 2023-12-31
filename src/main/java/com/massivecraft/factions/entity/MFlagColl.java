package com.massivecraft.factions.entity;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.factions.Const;
import com.massivecraft.factions.Factions;
import com.massivecraft.massivecore.PriorityComparator;
import com.massivecraft.massivecore.store.Coll;
import com.massivecraft.massivecore.store.MStore;

public class MFlagColl extends Coll<MFlag>
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static MFlagColl i = new MFlagColl();
	public static MFlagColl get() { return i; }
	private MFlagColl()
	{
		super(Const.COLLECTION_MFLAG, MFlag.class, MStore.getDb(), Factions.get(), false, false, true, null, PriorityComparator.get());
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void init()
	{
		super.init();
		MFlag.setupStandardFlags();
	}
	
	// -------------------------------------------- //
	// EXTRAS
	// -------------------------------------------- //
	
	public List<MFlag> getAll(boolean registered)
	{
		List<MFlag> ret = new ArrayList<MFlag>();
		for (MFlag mflag : this.getAll())
		{
			if (mflag.isRegistered() != registered) continue;
			ret.add(mflag);
		}
		return ret;
	}
	
}
