package be.gerard.rhozeta.core.service;

import be.gerard.rhozeta.shared.service.TranslationService;
import be.gerard.rhozeta.shared.model.Application;
import be.gerard.rhozeta.shared.model.Translation;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TranslationServiceImpl
 *
 * @author bartgerard
 * @version v0.0.1
 */
@Service
public class TranslationServiceImpl implements TranslationService {

    @Override
    public List<Translation> findAll(Application.Key appKey) {
        return null;
    }

}
