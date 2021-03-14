package metier;

import dao.IDao;

public class MetierImpl implements IMetier{
    private IDao dao;

    @Override
    public double calcul() {
        double data = dao.getValue();
        double res = data * 2;
        return res;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
