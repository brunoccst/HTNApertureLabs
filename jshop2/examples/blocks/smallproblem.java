import java.util.LinkedList;
import JSHOP2.*;

public class smallproblem
{
	private static String[] defineConstants()
	{
		String[] problemConstants = new String[4];

		problemConstants[0] = "b1";
		problemConstants[1] = "b2";
		problemConstants[2] = "b3";
		problemConstants[3] = "b4";

		return problemConstants;
	}

	private static void createState0(State s)	{
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(11), TermList.NIL)));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(12), TermList.NIL)));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(13), TermList.NIL)));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(14), TermList.NIL)));
		s.add(new Predicate(1, 0, new TermList(TermConstant.getConstant(11), TermList.NIL)));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(12), new TermList(TermConstant.getConstant(11), TermList.NIL))));
		s.add(new Predicate(0, 0, new TermList(TermConstant.getConstant(12), TermList.NIL)));
		s.add(new Predicate(1, 0, new TermList(TermConstant.getConstant(13), TermList.NIL)));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(14), new TermList(TermConstant.getConstant(13), TermList.NIL))));
		s.add(new Predicate(0, 0, new TermList(TermConstant.getConstant(14), TermList.NIL)));
	}

	public static LinkedList<Plan> getPlans()
	{
		LinkedList<Plan> returnedPlans = new LinkedList<Plan>();
		TermConstant.initialize(15);

		Domain d = new blocks();

		d.setProblemConstants(defineConstants());

		State s = new State(11, d.getAxioms());

		JSHOP2.initialize(d, s);

		TaskList tl;
		SolverThread thread;

		createState0(s);

		tl = new TaskList(1, true);
		tl.subtasks[0] = new TaskList(new TaskAtom(new Predicate(5, 0, new TermList(new TermList(new TermList(TermConstant.getConstant(1), new TermList(TermConstant.getConstant(11), TermList.NIL)), new TermList(new TermList(TermConstant.getConstant(3), new TermList(TermConstant.getConstant(14), new TermList(TermConstant.getConstant(11), TermList.NIL))), new TermList(new TermList(TermConstant.getConstant(0), new TermList(TermConstant.getConstant(14), TermList.NIL)), new TermList(new TermList(TermConstant.getConstant(1), new TermList(TermConstant.getConstant(13), TermList.NIL)), new TermList(new TermList(TermConstant.getConstant(3), new TermList(TermConstant.getConstant(12), new TermList(TermConstant.getConstant(13), TermList.NIL))), new TermList(new TermList(TermConstant.getConstant(0), new TermList(TermConstant.getConstant(12), TermList.NIL)), TermList.NIL)))))), TermList.NIL)), false, false));

		thread = new SolverThread(tl, 1);
		thread.start();

		try {
			while (thread.isAlive())
				Thread.sleep(500);
		} catch (InterruptedException e) {
		}

		returnedPlans.addAll( thread.getPlans() );

		return returnedPlans;
	}

	public static LinkedList<Predicate> getFirstPlanOps() {
		return getPlans().getFirst().getOps();
	}
}