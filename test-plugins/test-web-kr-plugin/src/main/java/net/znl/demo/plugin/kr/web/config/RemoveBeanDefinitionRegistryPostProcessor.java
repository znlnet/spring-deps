package net.znl.demo.plugin.kr.web.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.HashSet;
import java.util.Set;

/**
 * 移除不用的Bean
 */
@Profile("kr")//代表在只要启用韩国的时候才托管
@Configuration
public class RemoveBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    private static final Set<String> beanClassSets = new HashSet<>();

    static {
        beanClassSets.add("net.znl.demo.controller.UserController");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        String[] beanNames = registry.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = registry.getBeanDefinition(beanName);
            if (beanClassSets.contains(beanDefinition.getBeanClassName())) {
                // 移除对应类的 BeanDefinition
                registry.removeBeanDefinition(beanName);
                System.out.println("Removed BeanDefinition: " + beanDefinition.getBeanClassName());
            }
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 这里不需要做任何事情
    }
}
