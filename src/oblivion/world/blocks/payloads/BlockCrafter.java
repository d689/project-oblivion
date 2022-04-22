package oblivion.world.blocks.payloads;

import arc.util.*;
import arc.func.*;
import arc.struct.*;
import arc.util.io.*;
import arc.graphics.g2d.*;
import mindustry.gen.*;
import mindustry.world.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.world.consumers.*;
import mindustry.world.blocks.payloads.*;

// crafter that makes blocks(probably there is an already working one in mindustry but idk how that one would work)
public class BlockCrafter extends PayloadBlock {
	public Effect craftEffect = Fx.none;
	// draw cons over or under top region
	public boolean lowAltitude = false;
	public Cons<Building> drawer = build -> {};
	public Block outputBlock = Blocks.copperWall;
	public float craftTime = 60f;

	public BlockCrafter(String name) {
		super(name);
		solid = destructible = true;
		outputsPayload = true;
		hasPower = hasItems = true;
		rotate = true;
	}

	public TextureRegion[] icons() {return new TextureRegion[]{region, outRegion, topRegion};}

	public class BlockCrafterBuild extends PayloadBlockBuild {
		float reload = 0f;

		@Override
		public void updateTile() {
			if (cons.valid()) {
				reload += Time.delta;
				if (reload >= craftTime) {
					payload = new BuildPayload(outputBlock, team);
					craftEffect.at(x, y);
				}
			}
			moveOutPayload();
		}

		@Override
		public void draw() {
			Draw.rect(region, x, y, 0f);
			Draw.rect(outRegion, x, y, block.rotate ? rotdeg() : 0f);
			if(lowAltitude){drawer.get(this);} else {Draw.rect(topRegion, x, y, 0);}
			if(!lowAltitude){drawer.get(this);} else {Draw.rect(topRegion, x, y, 0);}
		}

		@Override
		public boolean acceptPayload(Building source, Payload payload) {return false;}

		@Override
		public void write(Writes write){
			super.write(write);
			write.f(reload);
		}
		
		@Override
		public void read(Reads read, byte revision){
			super.read(read, revision);
			reload = read.f();
		}
	}
}