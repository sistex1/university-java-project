package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(productRepository.count() == 0) {
            Product prebuiltA = new Product();
            prebuiltA.setName("MAXTEK Cyber i77 Platinum");
            prebuiltA.setInv(5);
            prebuiltA.setPrice(2699.99);
            prebuiltA.setId(1);
            productRepository.save(prebuiltA);

            Product prebuiltB = new Product();
            prebuiltB.setName("MAXTEK Tekki gs20");
            prebuiltB.setInv(9);
            prebuiltB.setPrice(1999.99);
            prebuiltB.setId(2);
            productRepository.save(prebuiltB);

            Product prebuiltC = new Product();
            prebuiltC.setName("MAXTEK Cyber i66 Gold");
            prebuiltC.setInv(3);
            prebuiltC.setPrice(1199.99);
            prebuiltC.setId(3);
            productRepository.save(prebuiltC);

            Product prebuiltD = new Product();
            prebuiltD.setName("MAXTEK Cyber i55");
            prebuiltD.setInv(17);
            prebuiltD.setPrice(999.99);
            prebuiltD.setId(4);
            productRepository.save(prebuiltD);

            Product prebuiltE = new Product();
            prebuiltE.setName("MAXTEK Tekki gs20 START");
            prebuiltE.setInv(30);
            prebuiltE.setPrice(499.99);
            prebuiltE.setId(5);
            productRepository.save(prebuiltE);
        }

        if(inhousePartRepository.count() == 0) {
            InhousePart tower = new InhousePart();
            tower.setName("MAXTEK Stealth ATX/Micro ATX ARGB");
            tower.setInv(100);
            tower.setId(255);
            tower.setPrice(97.59);
            inhousePartRepository.save(tower);

            InhousePart cooler = new InhousePart();
            cooler.setName("MAKTEK FLEX AIO Water Cooler (360mm)");
            cooler.setInv(67);
            cooler.setId(1243);
            cooler.setPrice(114.47);
            inhousePartRepository.save(cooler);
        }
        if(outsourcedPartRepository.count() == 0){
            OutsourcedPart gpu =  new OutsourcedPart();
            gpu.setName("Avid-N STX 7300-S");
            gpu.setInv(200);
            gpu.setId(50);
            gpu.setPrice(1859.79);
            outsourcedPartRepository.save(gpu);

            OutsourcedPart cpu =  new OutsourcedPart();
            cpu.setName("notel core j56S");
            cpu.setInv(137);
            cpu.setId(890);
            cpu.setPrice(323.49);
            outsourcedPartRepository.save(cpu);

            OutsourcedPart mobo =  new OutsourcedPart();
            mobo.setName("misi motherboard MEG X4390-C");
            mobo.setInv(790);
            mobo.setId(577);
            mobo.setPrice(129.99);
            outsourcedPartRepository.save(mobo);
        }

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
