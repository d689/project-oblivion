package oblivion.graphics;

import arc.math.*;
import arc.util.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.entities.*;

public class LamoniFx {
	public static final Effect 
	imperialSmelt = new Effect(300f, e -> {
		e.scaled(45f, b -> {
			Draw.color(Pal.accent, Pal.lancerLaser, b.fin());
			Lines.stroke(3f * b.foutpow());
			Angles.randLenVectors(b.id, 5, 40f * b.finpow(), (x, y) -> {
				Lines.lineAngle(b.x + x, b.y + y, Mathf.angle(x, y), 5f * b.fout());
			});
		});
		
		Draw.color(Pal.metalGrayDark);
		if (Mathf.randomSeed(e.id, 1) > 0.5f) {
			Angles.randLenVectors(e.id, 3, 40f * e.finpow(), (x, y) ->  {
				Fill.circle(e.x + x, e.y + y, 3f * Interp.slowFast.apply(e.fout()));
			});
		}
	}),

	hafniumSmelt = new Effect(120f, e -> {
		Draw.color(Color.black);
		Draw.alpha(0.5f);
		Angles.randLenVectors(e.id, 20, 40 * e.finpow(), (x, y) -> {
			Fill.circle(e.x + x, e.y + y, e.fout() * 2f);
		});
		Draw.color(Pal.accent);
		e.scaled(20f, b -> {
			Lines.stroke(b.fout());
			Angles.randLenVectors(e.id + 1, 10, 40f * b.finpow(), (x, y) -> {
				Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 10f * b.foutpow());
			});
		});
		e.scaled(40f, b -> {
			Lines.stroke(b.fout());
			Angles.randLenVectors(e.id + 2, 10, 40f * b.finpow(), (x, y) -> {
				Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 10f * b.foutpow());
			});
		});
		e.scaled(60f, b -> {
			Lines.stroke(b.fout());
			Angles.randLenVectors(e.id + 3, 10, 40f * b.finpow(), (x, y) -> {
				Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 10f * b.foutpow());
			});
		});
		e.scaled(80f, b -> {
			Lines.stroke(b.fout());
			Angles.randLenVectors(e.id + 4, 10, 40f * b.finpow(), (x, y) -> {
				Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 10f * b.foutpow());
			});
		});
	}),

	waterSpill = new Effect(30f, e -> {
		Draw.color(Liquids.water.color.cpy().mul(1.3f));
		Lines.stroke(e.fout() * 2f);
		Angles.randLenVectors(e.id, 5, 40f * e.finpow(), (x, y) -> {
			Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 10f * e.foutpow());
		});
		
		Lines.stroke(e.fout());
		Angles.randLenVectors(e.id + 1, 5, 40f * e.finpow(), (x, y) -> {
			Lines.circle(e.x + x, e.y + y, 5f * e.foutpow());
		});
	});
}