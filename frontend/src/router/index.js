import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/housingProjects',
      component: () => import('../components/ui/HousingProjectGrid.vue'),
    },
    {
      path: '/houseSupplies',
      component: () => import('../components/ui/HouseSupplyGrid.vue'),
    },
    {
      path: '/announcements',
      component: () => import('../components/ui/AnnouncementGrid.vue'),
    },
    {
      path: '/subscriptions',
      component: () => import('../components/ui/SubscriptionGrid.vue'),
    },
    {
      path: '/notifications',
      component: () => import('../components/ui/NotificationGrid.vue'),
    },
    {
      path: '/winners',
      component: () => import('../components/ui/WinnerGrid.vue'),
    },
    {
      path: '/winningDashboards',
      component: () => import('../components/WinningDashboardView.vue'),
    },
    {
      path: '/tenants',
      component: () => import('../components/ui/TenantGrid.vue'),
    },
    {
      path: '/maintenances',
      component: () => import('../components/ui/MaintenanceGrid.vue'),
    },
    {
      path: '/contracts',
      component: () => import('../components/ui/ContractGrid.vue'),
    },
    {
      path: '/extendContracts',
      component: () => import('../components/ui/ExtendContractGrid.vue'),
    },
    {
      path: '/contractDashboards',
      component: () => import('../components/ContractDashboardView.vue'),
    },
  ],
})

export default router;
