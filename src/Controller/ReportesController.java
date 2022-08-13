package Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.dao.ComprasDeLiderDao;
import model.dao.DeudasPorProyectoDao;
import model.dao.InformeDosDao;
import model.dao.InformeTreDao;
import model.dao.Informe_unoDao;
import model.dao.ProyectoBancoDao;
import model.vo.ComprasDeLiderVo;
import model.vo.DeudasPorProyectoVo;
import model.vo.ProyectoBancoVo;

public class ReportesController {
    private ProyectoBancoDao proyectoBancoDao;
    private ComprasDeLiderDao comprasDeLiderDao;
    private DeudasPorProyectoDao pagadoPorProyectoDao;
    private Informe_unoDao informeUnoDao;
    private InformeDosDao informeDosDao;
    private InformeTreDao informeTresDao;

    public ReportesController() {
        proyectoBancoDao = new ProyectoBancoDao();
        comprasDeLiderDao = new ComprasDeLiderDao();
        pagadoPorProyectoDao = new DeudasPorProyectoDao();
        informeUnoDao = new Informe_unoDao();
        informeDosDao = new InformeDosDao();
        informeTresDao = new InformeTreDao();
    }

    public List<ProyectoBancoVo> listarProyectosPorBanco(String banco) throws SQLException {
        return proyectoBancoDao.listar(banco);
    }

    public List<DeudasPorProyectoVo> listarTotalAdeudadoProyectos(Double limite) throws SQLException {
        return pagadoPorProyectoDao.listar(limite);
    }

    public List<ComprasDeLiderVo> listarLideresQueMasGastan() throws SQLException {
        return comprasDeLiderDao.listar();
    }

    public ResultSet informe_uno(){
        return informeUnoDao.consultaInforme();
    }

    public ResultSet informe_dos(){
        return informeDosDao.consultaInforme();
    }

    public ResultSet informe_tres(){
        return informeTresDao.consultaInforme();
    }
}
