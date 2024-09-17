import { api } from 'src/boot/axios';
import { ApplicationResponseModel } from 'src/models/application.model';

class ApplicationService {
  static instance: ApplicationService;

  public static getInstance(): ApplicationService {
    if (ApplicationService.instance instanceof ApplicationService) {
      return this.instance;
    }
    ApplicationService.instance = new ApplicationService();
    return ApplicationService.instance;
  }

  async getApplications() {
    return await api.get<ApplicationResponseModel[]>('/applications');
  }
}

export { ApplicationService };
