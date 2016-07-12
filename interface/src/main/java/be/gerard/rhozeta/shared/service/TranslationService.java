package be.gerard.rhozeta.shared.service;

import be.gerard.rhozeta.shared.model.Application;
import be.gerard.rhozeta.shared.model.Translation;

import java.util.List;

/**
 * TranslationService
 *
 * @author bartgerard
 * @version v0.0.1
 */
public interface TranslationService {

    List<Translation> findAll(Application.Key appKey);

}
