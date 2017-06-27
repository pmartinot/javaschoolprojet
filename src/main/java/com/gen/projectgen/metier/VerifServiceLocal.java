/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen.projectgen.metier;

import com.gen.projectgen.model.Verif;
import javax.ejb.Local;

/**
 *
 * @author pierre
 */
@Local
public interface VerifServiceLocal {
    
    public void verifDecrypted(Verif verif);
        
}
